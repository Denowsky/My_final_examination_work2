package Exception;

public class Counter implements AutoCloseable {
    private int count;
    private boolean resourceClosed;

    public void Count() {
        this.count = 0;
        this.resourceClosed = false;
    }

    public void add() {
        if (resourceClosed) {
            throw new IllegalStateException("Работа счётчика вне ресурса");
        }
        count++;
    }

    public int getCount() {
        return count;
    }

    public void setResourceClosed(boolean resourceClosed) {
        this.resourceClosed = resourceClosed;
    }

    @Override
    public void close() {
        this.resourceClosed = true;
    }
}