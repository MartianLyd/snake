package com.kryocore.common.Balking;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.currentThread;

//代表正在编辑的文档类
public class Document {
    private boolean changed = false;
    private List<String> content = new ArrayList<>();

    private final FileWriter writer;

    private static AutoSaveThread autoSaveThread;

    public Document(String documentPath ,String documentName) throws IOException{
        this.writer = new FileWriter(new File(documentPath,documentName),true);
    }

    private static Document create(String documentPath,String documentName) throws IOException{
        Document document = new Document(documentPath,documentName);
        autoSaveThread = new AutoSaveThread(document);
        autoSaveThread.start();
        return document;
    }

    public void edit(String s){
        synchronized (this){
            this.content.add(s);
            this.changed = true;
        }
    }
    public void close() throws IOException {
        autoSaveThread.interrupt();
        writer.close();
    }

    public void save() throws IOException {
        synchronized (this){
            if(!changed){
                return;
            }
            System.out.println(currentThread() + " execute the save action.");
            for(String cacheLine:content){
                this.writer.write(cacheLine);
                this.writer.write("\r\n");
            }
            this.writer.flush();
            this.changed = false;
            this.content.clear();
        }
    }

}
