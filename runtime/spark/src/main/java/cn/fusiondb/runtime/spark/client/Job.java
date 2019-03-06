package cn.fusiondb.runtime.spark.client;

import java.io.Serializable;

/**
 * Interface for a Spark remote job.
 */
public interface Job<T> extends Serializable {
    T call(JobContext jc) throws Exception;
}
