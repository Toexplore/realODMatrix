package realODMatrix.spout;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;
import realODMatrix.spout.TupleInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
import java.util.Random;

public class FieldListenerSpout extends BaseRichSpout {
    private SpoutOutputCollector _collector;
    private BufferedReader fileReader;
    private Random _rand;   
    private TopologyContext context;
    private String file="/home/ghchen/2013-01-05.1/2013-01-05--11_05_48.txt";
    
    private TupleInfo tupleInfo;
    
    

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        _collector = collector;
        //_rand = new Random();
	try 
    	{	
		 this.context=context;
    	 this.fileReader = new BufferedReader(new FileReader(new File(file)));
    	} 
    	catch (FileNotFoundException e) 
    	{
    		throw new RuntimeException ("error reading file ["+file+"]");
    	    //System.exit(1);
    	}
    }

    @Override
    public void nextTuple() {
    	
   
        Utils.sleep(2000);
       // RandomAccessFile access = null; 
        String line = null;  
        BufferedReader access= new BufferedReader(fileReader);
           try 
           { 
               while ((line = access.readLine()) != null)
               { 
                   if (line !=null)
                   {
                       String[] fields=null;
                       
						//Fields fields;
						//TupleInfo  tupleInfo;
						if (tupleInfo.getDelimiter().equals("|"))
                           fields = line.split("\\"+tupleInfo.getDelimiter());
                        else   fields = line.split(tupleInfo.getDelimiter());                                                
                        if (tupleInfo.getFieldList().size() == fields.length)
                           _collector.emit(new Values(fields)); 
                   }          
               } 
          } 
          catch (IOException ex) { }               
        //}
    
    
    }        

    @Override
    public void ack(Object id) {
    }

    @Override
    public void fail(Object id) {
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
       // declarer.declare(new Fields("word"));
	String[] fieldsArr = new String [tupleInfo.getFieldList().size()];
        for(int i=0; i<tupleInfo.getFieldList().size(); i++)
        {
            fieldsArr[i] = tupleInfo.getFieldList().get(i).getClass().toString();//.getColumnName();
        }           
        declarer.declare(new Fields(fieldsArr));

    }

    
}
