package cn.fusiondb.runtime.spark.client;

import java.util.concurrent.Future;

/**
 * A handle to a submitted job. Allows for monitoring and controlling of the running remote job.
 */
public interface JobHandle<T> extends Future<T> {

    /**
     * Return the current state of the job.
     *
     * @return The current State of this job
     */
    State getState();

    /**
     * Add a listener to the job handle. If the job's state is not SENT, a callback for the
     * corresponding state will be invoked immediately.
     *
     * @param l The listener to add.
     */
    void addListener(Listener<T> l);

    /**
     * The current state of the submitted job.
     */
    static enum State {
        SENT,
        QUEUED,
        STARTED,
        CANCELLED,
        FAILED,
        SUCCEEDED;
    }

    /**
     * A listener for monitoring the state of the job in the remote context. Callbacks are called
     * when the corresponding state change occurs.
     */
    static interface Listener<T> {

        /**
         * Notifies when a job has been queued for execution on the remote context. Note that it is
         * possible for jobs to bypass this state and got directly from the SENT state to the STARTED
         * state.
         *
         * @param job The JobHandle for the queued job
         */
        void onJobQueued(JobHandle<T> job);

        void onJobStarted(JobHandle<T> job);

        void onJobCancelled(JobHandle<T> job);

        void onJobFailed(JobHandle<T> job, Throwable cause);

        void onJobSucceeded(JobHandle<T> job, T result);

    }

}

