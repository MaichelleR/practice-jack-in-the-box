import exceptions.JakeInTheBoxAlreadyClosedException;

public class JackInTheBox {

    private int cranks;

    private boolean isOpen;

    public JackInTheBox() {
        this.cranks = 0;
        isOpen = false;

    }

    public int getCranks() {
        return cranks;
    }

    public boolean isOpen() {
        return isOpen;
    }


    public void turnCrank() {
        playMusic();
        cranks++;
        if (cranks == 3  && isOpen == false){
            open();

        }

    }

    private void open() {
        isOpen = true;
        System.out.println("Pop\uD83E\uDD21 ");
    }

    public void close() {
        if (isOpen == false) {
            throw new JakeInTheBoxAlreadyClosedException("Jack in the box is already closed ");
        }
        isOpen = false;
        cranks =0;
        System.out.println("You closed the Jack in the Box");
    }

    private void playMusic() {
        System.out.println("♪ ♪ ♪ ");
    }

}
