package word_count;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class mapper extends Mapper<Object, Text, Text, IntWritable>{

    public void map(Object key, Text value, Context context
                ) throws IOException, InterruptedException {
        
        String[] s = value.toString().split(" ");
        for(String word : s) {
            context.write(new Text(word), new IntWritable(1));
        }

    }
}
