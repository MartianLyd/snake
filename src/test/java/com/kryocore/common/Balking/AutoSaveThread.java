package com.kryocore.common.Balking;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AutoSaveThread extends Thread{
    private final Document document;

    public AutoSaveThread(Document document){
        super("DocumentAutoSaveThread");
        this.document = document;
    }

    @Override
    public void run(){
        while (true){
            try{
                document.save();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
