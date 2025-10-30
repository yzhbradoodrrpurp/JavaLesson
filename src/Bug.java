public class Bug {
    private int position;
    private int direction;  // -1 for left, 1 for right

    public Bug(){
        position = 0;
        direction = 1;
    }

    void turn(int direction){
        assert direction == -1 || direction == 1 : "Direction must be -1 (left) or 1 (right)";
        this.direction = direction;
    }

    void move() {
        if (direction == 1)
            position += 1;
        else if (direction == -1)
                position -= 1;
        else
            throw new IllegalArgumentException("Direction must be -1 (left) or 1 (right)");
    }

    int getPosition(){
        return position;
    }

    public static void main(String[] args){
        Bug bug = new Bug();
        bug.move();
        bug.move();
        System.out.println(bug.getPosition()); // 2
        bug.turn(-1);
        bug.move();
        System.out.println(bug.getPosition()); // 1
        bug.turn(1);
        bug.move();
        bug.move();
        bug.move();
        System.out.println(bug.getPosition()); // 4
    }
}

