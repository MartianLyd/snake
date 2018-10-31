package com.kryocore.snake.nlp;

import java.util.ArrayList;
import java.util.List;

import com.aliasi.sentences.IndoEuropeanSentenceModel;
import com.aliasi.sentences.SentenceModel;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.Tokenizer;
import com.aliasi.tokenizer.TokenizerFactory;

/**
 * 中英文段落断句分词
 */
public class SpliteTextInSentence {
    static final TokenizerFactory TOKENIZER_FACTORY = IndoEuropeanTokenizerFactory.INSTANCE;
    static final SentenceModel SENTENCE_MODEL = new IndoEuropeanSentenceModel();
    //这里我选择了好多典型例子，属于正则表达式筛选会有问题的，你们的正则如果都能处理你牛逼，请留言给我，我也想要
    public static void main(String[] args) {
        SpliteTextInSentence s = new SpliteTextInSentence();
        String str1 = "Water-splashing Festival is one of the most important festivals in the world, which is popular among Dai people of China and the southeast Asia. It has been celebrated by people for more than 700 years and now this festival is an necessary way for people to promote the cooperation and communication among countries.";
        String str2 = "This is how I tried to split a paragraph into a sentence. But, there is a problem. My paragraph includes dates like Jan.13, 2014 , words like U.S and numbers like 2.2. They all got split by the above code.";
        String str3 = "My friend holds a Msc. in Computer Science.";
        String str4 = "This is a test? This is a T.L.A. test!";
        String text = "50 Cent XYZ120 DVD Player 50 Cent lawyer. Person is john, he is a lawyer.";
        String str5 = "\"I do not ask for your forgiveness,\" he said, in a tone that became more firm and forceful. \"I have no illusions, and I am convinced that death is waiting for me: it is just.\"";
        String str6 = "\"The Times have had too much influence on me.\" He laughed bitterly and said to himself, \"it is only two steps away from death. Alone with me, I am still hypocritical... Ah, the 19th century!\"";
        String str7 = "泼水节是世界上最重要节日之一，深受中国傣族和东南亚人民的喜爱。七百多年来，人们一直在庆祝这个节日，现在这个节日是促进国家间合作和交流的必要方式。他说：“他喜欢喝酒”。";
        String str8 = "El Gobernador de Nueva York, Andrew Cuomo, informó que un paquete sospechoso similar a otros con explosivos enviados a los Clinton y a Barack Obama le fue enviado.\n" +
                "\"Un paquete fue enviado a mi oficina en Manhattan, del que me acaban de informar\", señaló el Alcalde en conferencia de prensa.\n" +
                "\"No estaríamos sorprendidos de que más paquetes sean enviados\".\n" +
                "Las autoridades de Nueva York informaron que el paquete enviado a las oficinas de CNN en Nueva York tenía un explosivo y polvo blanco, dirigido al ex jefe de la CIA John Brennan.\n" +
                "\"Lo que vimos hoy es un intento de terrorismo, un acto terrorista en contra de nuestra prensa libre y contra líderes del país\", aseguró el Alcalde Bill de Blasio.\n" +
                "Otros paquetes han sido interceptados hoy de camino a la casa del ex Presidente Barack Obama, la ex Secretaria de Estado Hillary Clinton.\n";


        String str10 = "\n" +
                "燕山深处，淬火砺刃。武警部队第二届“巅峰”特战比武竞赛间隙，各参赛队正利用有限的休息时间紧张复盘得失，积极调整状态，准备迎接下一个课目的挑战。\n" +
                "实战导向鲜明，“超越”劲头正满。10分钟时限，负重近50斤，完成2公里山地越野，并对6个隐显目标实施射击……在2公里武装越野射击课目中，来自武警新疆总队某部的参赛队员李金铭命中了4个目标。他所在的参赛队伍，以人均近3发命中的成绩位居前列。“虽然成绩还不错，但仍有很大努力和提高的空间。”李金铭略带遗憾地说。\n" +
                "对超越对手，取得佳绩，李金铭信心满满。这信心，来自反恐一线日复一日的摸爬滚打，来自长期以来贴近实战的千锤百炼。“平时我们始终瞄着实战练，爬的山更高，跑的路更难，真正面对极限考验时才能从容应对。”\n" +
                "来自内蒙古总队的倪祥喜今年33岁，是参赛小队长中年纪最大的。经历过首届“巅峰”特战比武的他，对以比促训、以赛强能有着更加深切的体会。\n" +
                "回想起参加上届“巅峰”特战比武武装越野射击课目的情形，倪祥喜自嘲地说“都是泪”。时限到了，他才刚刚抵达射击地线，眼巴巴地看着对面的目标停止显靶，连出枪射击的机会都没有抢到。\n";
        String str11 = "The $1.5bn (£1.\u200B17bn) project is designed to give scientists a better understanding of solar wind and geomagnetic storms that risk wreaking chaos on Earth by knocking out the power grid.";

        String str12 = "15亿美元（1英镑）项目旨在让科学家更好地了解太阳风和地磁风暴，这些风暴通过摧毁电网造成地球上的混乱。";

        System.out.println(s.splitfuhao(str10));
        List<String> sl = testChunkSentences(s.splitfuhao(str10));
        if(sl.isEmpty()){
            System.out.println("没有识别到句子");
        }
        for (String row : sl) {
            System.out.println(row);
        }
    }
    //这个是引用句子识别的方法，找了好多资料，在一个用它做文本分析里的找到的↓
    //https://blog.csdn.net/textboy/article/details/45580009
    private static List<String> testChunkSentences(String text) {
        List<String> result = new ArrayList<String>();
        List<String> tokenList = new ArrayList<String>();
        List<String> whiteList = new ArrayList<String>();
        Tokenizer tokenizer = TOKENIZER_FACTORY.tokenizer(text.toCharArray(),
                0, text.length());
        tokenizer.tokenize(tokenList, whiteList);
        String[] tokens = new String[tokenList.size()];
        String[] whites = new String[whiteList.size()];
        tokenList.toArray(tokens);
        whiteList.toArray(whites);
        int[] sentenceBoundaries = SENTENCE_MODEL.boundaryIndices(tokens,
                whites);
        int sentStartTok = 0;
        int sentEndTok = 0;

        for (int i = 0; i < sentenceBoundaries.length; ++i) {
            System.out.println("Sentense " + (i + 1) + ", sentense's length(from 0):" + (sentenceBoundaries[i]));
            StringBuilder sb = new StringBuilder();
            sentEndTok = sentenceBoundaries[i];
            for (int j = sentStartTok; j <= sentEndTok; j++) {
                sb.append(tokens[j]).append(whites[j + 1]);
            }
            sentStartTok = sentEndTok + 1;
            result.add(sb.toString());
        }
        System.out.println("Final result:" + result);
        return result;
    }
    //替换中文标点符号，用于检测是否识别中文分句
    public String splitfuhao(String str){
        String[] ChineseInterpunction = { "“", "”", "‘", "’", "。", "，", "；", "：", "？", "！", "……", "—", "～", "（", "）", "《", "》" };
        String[] EnglishInterpunction = { "\"", "\"", "'", "'", ".", ",", ";", ":", "?", "!", "…", "-", "~", "(", ")", "<", ">" };
        for (int j = 0; j < ChineseInterpunction.length; j++)
        {
            //alert("txt.replace("+ChineseInterpunction[j]+", "+EnglishInterpunction[j]+")"); 
            //String reg=str.matches(ChineseInterpunction[j],"g"); 
            str = str.replace(ChineseInterpunction[j], EnglishInterpunction[j]+"");
//            str = str.replace(ChineseInterpunction[j], EnglishInterpunction[j]);
        }
        return str;
    }

}

