package cn.fusiondb.runtime.spark.client;

import java.io.File;
import java.net.URI;
import java.util.concurrent.Future;

/**
 * A client for submitting Spark-based jobs to a Livy backend.
 */
public interface LivyClient {

    /**
     * Submits a job for asynchronous execution.
     *
     * @param <T> The return type of the job
     * @param job The job to execute.
     * @return A handle that be used to monitor the job.
     */
    <T> JobHandle<T> submit(Job<T> job);

    /**
     * Asks the remote context to run a job immediately.
     * <p>
     * Normally, the remote context will queue jobs and execute them based on how many worker
     * threads have been configured. This method will run the submitted job in the same thread
     * processing the RPC message, so that queueing does not apply.
     * <p>
     * It's recommended that this method only be used to run code that finishes quickly. This
     * avoids interfering with the normal operation of the context.
     * <p>
     *
     * @param <T> The return type of the job
     * @param job The job to execute.
     * @return A future to monitor the result of the job.
     */
    <T> Future<T> run(Job<T> job);

    /**
     * Stops the remote context.
     *
     * Any pending jobs will be cancelled, and the remote context will be torn down.
     *
     * @param shutdownContext Whether to shutdown the underlying Spark context. If false, the
     *                        context will keep running and it's still possible to send commands
     *                        to it, if the backend being used supports it.
     */
    void stop(boolean shutdownContext);

    /**
     * Upload a jar to be added to the Spark application classpath
     * @param jar The local file to be uploaded
     * @return A future that can be used to monitor this operation
     */
    Future<?> uploadJar(File jar);

    /**
     * Adds a jar file to the running remote context.
     * <p>
     * Note that the URL should be reachable by the Spark driver process. If running the driver
     * in cluster mode, it may reside on a different host, meaning "file:" URLs have to exist
     * on that node (and not on the client machine).
     * <p>
     * If the provided URI has no scheme, it's considered to be relative to the default file system
     * configured in the Livy server.
     *
     * @param uri The location of the jar file.
     * @return A future that can be used to monitor the operation.
     */
    Future<?> addJar(URI uri);

    /**
     * Upload a file to be passed to the Spark application
     * @param file The local file to be uploaded
     * @return A future that can be used to monitor this operation
     */
    Future<?> uploadFile(File file);

    /**
     * Adds a file to the running remote context.
     * <p>
     * Note that the URL should be reachable by the Spark driver process. If running the driver
     * in cluster mode, it may reside on a different host, meaning "file:" URLs have to exist
     * on that node (and not on the client machine).
     * <p>
     * If the provided URI has no scheme, it's considered to be relative to the default file system
     * configured in the Livy server.
     *
     * @param uri The location of the file.
     * @return A future that can be used to monitor the operation.
     */
    Future<?> addFile(URI uri);

}