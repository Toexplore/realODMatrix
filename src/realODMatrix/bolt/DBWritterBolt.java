/**
 * realODMatrix realODMatrix.bolt DBWritter.java
 *
 * Copyright 2013 Xdata@SIAT
 * Created:2013-1-8 ����4:32:35
 * email: gh.chen@siat.ac.cn
 */
package realODMatrix.bolt;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;

/**
 * realODMatrix realODMatrix.bolt DBWritter.java
 *
 * Copyright 2013 Xdata@SIAT
 * Created:2013-1-8 ����4:32:35
 * email: gh.chen@siat.ac.cn
 *
 */
public class DBWritterBolt implements IRichBolt {

	
	@Override
	public void prepare(Map stormConf, TopologyContext context,
			OutputCollector collector) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void execute(Tuple input) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public Map<String, Object> getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
