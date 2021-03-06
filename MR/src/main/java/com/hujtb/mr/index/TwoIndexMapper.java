package com.hujtb.mr.index;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 *
 * @author hujtb
 * @create on 2018-12-27-16:26
 */
public class TwoIndexMapper extends Mapper<LongWritable, Text, Text, Text> {
    Text k = new Text();
    Text v = new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //atguigu--a.txt 3
        String line = value.toString();
        String[] fields = line.split("--");
        k.set(fields[0]);
        v.set(fields[1]);
        context.write(k, v);
    }
}
