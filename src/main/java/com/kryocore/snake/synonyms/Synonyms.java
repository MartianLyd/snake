package com.kryocore.snake.synonyms;

import java.util.*;
import java.io.File;

import com.alibaba.fastjson.JSONObject;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import org.springframework.web.bind.annotation.*;

@RestController
public class Synonyms {
	private static Hashtable<String, String> hashtable = new Hashtable<String, String>();
	
	private static void init() {
		if ((new File("./hashtable.ser")).exists())
			Synonyms.hashtable = (new SerializableHashtable()).load("./hashtable.ser").get();
		else {
			ExcelOperator operator = new ExcelOperator("synonyms.xls");
			ArrayList<String[]> pairs = new ArrayList<String[]>();
			pairs.addAll(operator.getPairs(0, 0, 1));
			pairs.addAll(operator.getPairs(0, 3, 1));
			pairs.addAll(operator.getPairs(0, 6, 1));
			operator.close();
			
			SerializableHashtable serializableHashtable = new SerializableHashtable(pairs);
			serializableHashtable.store("./hashtable.ser");
			Synonyms.hashtable = serializableHashtable.get();
		}
	}
	
	private static String getSynonym(String origin) {
		if (Synonyms.hashtable.containsKey(origin)) return Synonyms.hashtable.get(origin);
		return origin;
	}

	@RequestMapping(value="/synonyms2" ,method = RequestMethod.POST)
	private String synonymsReplacement5(@RequestBody String paramsSyn) {
//		logger.info("content" + paramsSyn); // ['1','2','3']

		paramsSyn = paramsSyn.substring(1,paramsSyn.length()-1);

		String[] pList = paramsSyn.split(",",-1);
		double threshold = 0.1;
		Map<String, String> paramsResult = new HashMap<String, String>();
		for(int k = 0;k < pList.length;k++) {
			String key = pList[k].replace("'","");
			System.out.println(key + " " + key);
			if (threshold > 1.0d) return key;
			if (threshold < 0.0d) threshold = 0.0d;


			List<Term> termsList = HanLP.segment(key);
			String out = "";
			for (Iterator<Term> termsIterator = termsList.iterator(); termsIterator.hasNext();) {
				Term term = termsIterator.next();
				String word = ((new Random()).nextDouble() >= threshold) ? getSynonym(term.word) : term.word;
				out += word;
			}
			paramsResult.put(key,out);
		}
		String data = String.format(JSONObject.toJSONString(paramsResult)).replace("\"","'");

		return data;
	}

	@RequestMapping(value="/synonyms" ,method = RequestMethod.POST)
	private static String synonymsReplacement3(@RequestBody Map<String, Object> params2) {
		String origin = (String)params2.get("origin");
		double threshold = 0.1;
		Synonyms.init();
		if (threshold > 1.0d) return origin;
		if (threshold < 0.0d) threshold = 0.0d;
		System.out.println("---------------------" + origin);

		List<Term> termsList = HanLP.segment(origin);
		String out = "";
		for (Iterator<Term> termsIterator = termsList.iterator(); termsIterator.hasNext();) {
			Term term = termsIterator.next();
			String word = ((new Random()).nextDouble() >= threshold) ? Synonyms.getSynonym(term.word) : term.word;
			out += word;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("result", out);


		String data = String.format("data=%s", JSONObject.toJSONString(params));

		return data;
	}

	@RequestMapping(value="/synonyms/{origin}" ,method = RequestMethod.GET)
	private static String synonymsReplacement2(@PathVariable String origin) {
		double threshold = 0.1;
		Synonyms.init();
		if (threshold > 1.0d) return origin;
		if (threshold < 0.0d) threshold = 0.0d;
		System.out.println("---------------------" + origin);

		List<Term> termsList = HanLP.segment(origin);
		String out = "";
		for (Iterator<Term> termsIterator = termsList.iterator(); termsIterator.hasNext();) {
			Term term = termsIterator.next();
			String word = ((new Random()).nextDouble() >= threshold) ? Synonyms.getSynonym(term.word) : term.word;
			out += word;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("result", out);


		String data = String.format("data=%s", JSONObject.toJSONString(params));

		return data;
	}

	@RequestMapping(value="/showUser/{origin}" ,method = RequestMethod.GET)
	private static String synonymsReplacement(String origin, double threshold) {
		Synonyms.init();
		if (threshold > 1.0d) return origin;
		if (threshold < 0.0d) threshold = 0.0d;
		
		List<Term> termsList = HanLP.segment(origin);
		String out = "";
		for (Iterator<Term> termsIterator = termsList.iterator(); termsIterator.hasNext();) {
			 Term term = termsIterator.next();
			 String word = ((new Random()).nextDouble() >= threshold) ? Synonyms.getSynonym(term.word) : term.word;
			 out += word;
		}
		return out;
	}
	
	public static void main(String[] args) {
		Synonyms.init();
		String a1 = "作为华为今年最重磅的机型，无论是用户、还是各大媒体都非常关注。而华为的官方微博“华为终端公司”也频频宣传发力";
		double a2 = 0.1;
		System.out.println(Synonyms.synonymsReplacement(a1, a2));
	}
}
