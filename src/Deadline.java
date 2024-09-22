import jdk.jfr.Event;

class Deadline extends Event implements Completable  {
    private boolean complete; //Holds a boolean whether the task this deadline tracks is complete.

    @Override
    public void complete() { // sets the complete boolean to true
        this.complete = true;
    }

    @Override
    public boolean isComplete() { // returns the complete boolean
        return complete;
    }
}
