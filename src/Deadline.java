import java.time.LocalDateTime;

class Deadline extends Event implements Completable  {
    private boolean complete; //Holds a boolean whether the task this deadline tracks is complete.
    public Deadline(String name, LocalDateTime dateTime) {
        setName(name);
        setDateTime(dateTime);
    }

    @Override
    public void complete() { // sets the complete boolean to true
        this.complete = true;
    }

    @Override
    public boolean isComplete() { // returns the complete boolean
        return complete;
    }
}
