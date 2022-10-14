package resourceManager;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockResourceManager extends BasicResourceManager {

    /**
     * Set the resource and initialise the numbers of waiting processes, and the number of users, to zero.
     *
     * @param resource the resource managed by this manager
     * @param maxUses  the maximum number of uses permitted for this manager's resource.
     */

    final Lock lock = new ReentrantLock();

    ArrayList<Condition> list = new ArrayList<>();
    final Condition priority0 = lock.newCondition();
    final Condition priority1 = lock.newCondition();
    final Condition priority2 = lock.newCondition();
    final Condition priority3 = lock.newCondition();
    final Condition priority4 = lock.newCondition();
    final Condition priority5 = lock.newCondition();
    final Condition priority6 = lock.newCondition();
    final Condition priority7 = lock.newCondition();
    final Condition priority8 = lock.newCondition();
    final Condition priority9 = lock.newCondition();
    final Condition priority10 = lock.newCondition();

    public LockResourceManager(Resource resource, int maxUses) {
        super(resource, maxUses);

        list.add(priority0);
        list.add(priority1);
        list.add(priority2);
        list.add(priority3);
        list.add(priority4);
        list.add(priority5);
        list.add(priority6);
        list.add(priority7);
        list.add(priority8);
        list.add(priority9);
        list.add(priority10);
    }

    @Override
    public void requestResource(int priority) throws ResourceError {
        if (priority > 10 || priority < 0) {
            throw new ResourceError("AH! Priority has to be between (inclusive) 0 and 10.");
        }

        if (lock.tryLock()) {
            increaseNumberWaiting(priority);
            try {
                list.get(priority).await();
            } catch (InterruptedException i) {
                i.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    @Override
    public int releaseResource() throws ResourceError {
        for (int i = 10; i > -1; i--) {
            if (getNumberWaiting(i) > 0) {
                lock.lock();
                list.get(i).signal();
                decreaseNumberWaiting(i);
                return i;
            }
        }
        lock.lock();
        return NONE_WAITING;
    }
}
