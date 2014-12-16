

package com.weibo.learn.hadoop.mapred;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * MaxTemperatureMapper.java V1.1
 * @Author:June Li
 * @Date: 2014-8-6 上午10:41:36
 * @Description:TODO
 */
public class MaxTemperatureMapper 
	extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	private static final int MISSING = 9999;
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		
		String line = value.toString();
		String year = line.substring(6, 10);
		int airTemperature = Integer.parseInt(line.substring(10));
		if (airTemperature != MISSING) {
			context.write(new Text(year), new IntWritable(airTemperature));
		}
	}
}

