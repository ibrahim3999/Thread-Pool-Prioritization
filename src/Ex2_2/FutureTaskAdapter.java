package src.Ex2_2;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskAdapter<V> extends FutureTask {
    public Task<V> t;

    public FutureTaskAdapter(Runnable runnable, Object result) {
        super(Executors.callable(runnable, result));

    }

    @Override
    protected void set(Object v) {
      this.t  = (Task<V>) v;
    }


}

