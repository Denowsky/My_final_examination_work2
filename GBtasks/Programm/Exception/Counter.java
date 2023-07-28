package Exception;

public class Counter implements AutoCloseable {
    private int count;
    private boolean resourceClosed;

    public void Count() {
        this.count = 0;
        this.resourceClosed = false;
    }

    public void add() {
        if(resourceClosed) {
            throw new IllegalStateException("Ресурс уже закрыт");
        }
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() {
        this.resourceClosed = true;
    }
}