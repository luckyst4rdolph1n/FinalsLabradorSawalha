/**
	This GameFrame class is for the windows that each player will see.
    It sets up the game and connects and communicates with the server.
	
	@author Zandalee Beck Q. Labrador (233393); Shamika Anne E. Sawalha (235724) 
	@version 3 May 2024
	
	I have not discussed the Java language code in my program 
	with anyone other than my instructor or the teaching assistants 
	assigned to this course.

	I have not used Java language code obtained from another student, 
	or any other unauthorized source, either modified or unmodified.

	If any Java language code or documentation used in my program 
	was obtained from another source, such as a textbook or website, 
	that has been clearly noted with a proper citation in the comments 
	of my program.
**/
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameFrame implements Runnable{
    private JFrame frame;
    private int width;
    private int height;
    private GameCanvas gc;
   
    private Socket socket;
    public int playerID;
    public Player player1, player2;
    public KeyHandler playerKey;
    Thread gameThread;
    private ReadFromServer rfsRunnable;
    private WriteToServer wtsRunnable;

    private int FPS = 60;

    Background startingPage, bg1, gameover;
    Platforms baseGround, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14;
    boolean running;
    public ArrayList<Platforms> platforms;
    Breezy b1, b2, b3;
    public ArrayList<Breezy> breezies;
    public Flag flag;
    Chocy c1, c2, c3;
    public ArrayList<Chocy> chocies;

    private SoundFx bgm = new SoundFx();

    /**
    * constructor which sets the scene and players
    * @param w width 
    * @param h height
    */    

public GameFrame(int w, int h){
    frame = new JFrame();
    createGameScene();
    createPlayers();
    playerKey = new KeyHandler();
    bgm.PlaySound("/resources/music.wav", true);
    
    w = width;
    h = height;   
}

/**
 * sets up the GUI
 */

public void setUpGUI(){
    frame.setSize(width, height);
    frame.setTitle("Leap & Paws - Player # " + playerID);
    gc = new GameCanvas(800, 600, player1, player2, bg1, startingPage, platforms, breezies, chocies, flag, gameover);
    frame.add(gc);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.addKeyListener(playerKey);
    startGameThread();

}

/**
 * instantiates the players
 */

public void createPlayers(){
    if(playerID == 1){
        player1 = new Player(100, 530, "/resources/Asset9.png");
        player2 = new Player(300, 530, "/resources/frog2.png");
    }else{
        player2 = new Player(100, 530, "/resources/Asset9.png");
        player1 = new Player(300, 530, "/resources/frog2.png");
    }
}

/**
 * instantiates the entities
 */

public void createGameScene(){
    bg1 = new Background("/resources/grassland.png");
    startingPage = new Background("/resources/starting.png");
    gameover = new Background("/resources/gameover.png");
    baseGround = new Platforms("/resources/groundBase.png", 0, 570, 800, 31);
    p1 = new Platforms("/resources/platform1.png", 681, 480, 160, 33);
    p2 = new Platforms("/resources/platform2.png", 0, 480, 606, 33);
    p3 = new Platforms("/resources/platform3.png", 730, 375, 72, 33);
    p4 = new Platforms("/resources/platform4.png", 187, 355, 468, 34);
    p5 = new Platforms("/resources/platform5.png", 0, 375, 66, 33);
    p6 = new Platforms("/resources/platform6.png", 623, 287, 161, 33);
    p7 = new Platforms("/resources/smallPlatform.png", 519, 258, 33, 28);
    p8 = new Platforms("/resources/smallPlatform.png", 437, 239, 33, 28);
    p9 = new Platforms("/resources/smallPlatform.png", 323, 239, 33, 28);
    p10 = new Platforms("/resources/smallPlatform.png", 217, 231, 33, 28);
    p11 = new Platforms("/resources/smallPlatform.png", 121, 215, 33, 28);
    p12 = new Platforms("/resources/platform7.png", 0, 173, 101, 33);
    p13 = new Platforms("/resources/smallPlatform.png", 176, 110, 33, 28);
    p14= new Platforms("/resources/platform8.png", 251, 80, 550, 33);
    running = false;
    platforms = new ArrayList<Platforms>();
    addPlatforms();
    
    b1 = new Breezy(691, 331);
    b2 = new Breezy(122, 322);
    b3 = new Breezy(393, 154);
    breezies = new ArrayList<Breezy>();
    addBreezies();

    c1 = new Chocy(414, 324);
    c2 = new Chocy(580, 520);
    c3 = new Chocy(217, 72);
    chocies = new ArrayList<Chocy>();
    addChocies();
    
    flag = new Flag();
}

/**
 * populates the platforms ArrayList
 */
public void addPlatforms(){
platforms.add(baseGround);
platforms.add(p1);
platforms.add(p2);
platforms.add(p3);
platforms.add(p4);
platforms.add(p5);
platforms.add(p6);
platforms.add(p7);
platforms.add(p8);
platforms.add(p9);
platforms.add(p10);
platforms.add(p11);
platforms.add(p12);
platforms.add(p13);
platforms.add(p14);
}

/**
 * populates the breezies ArrayList
 */
public void addBreezies(){
breezies.add(b1);
breezies.add(b2);
breezies.add(b3);
}

/**
 * populates the chocies ArrayList
 */
public void addChocies(){
chocies.add(c1);
chocies.add(c2);
chocies.add(c3);
}

/**
 * connects the player to the server
 */
public void connectToServer(){
    try{
        Scanner inp = new Scanner(System.in);
        System.out.print("IP Address: ");
        String host = inp.nextLine();
        System.out.println("Port number: ");
        int portNum = Integer.parseInt(inp.nextLine());
        inp.close();
        socket = new Socket(host, portNum);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        playerID = in.readInt();
        System.out.println("You are player #" + playerID);
        if(playerID == 1){
            System.out.println("Waiting for Player #2 to connect...");
        }
        rfsRunnable = new ReadFromServer(in);
        wtsRunnable = new WriteToServer(out);
        rfsRunnable.waitForStartMsg();
    }catch(IOException ex){
        System.out.println("IOException from connectToServer");
    }
}

/**
 * reads data sent by the server
 */

private class ReadFromServer implements Runnable {
    private DataInputStream dataIn;
    public ReadFromServer(DataInputStream in){
        dataIn = in;
        System.out.println("RFS Runnable created");
    }
    public void run(){
        try{
            while(true){
                player2.setX(dataIn.readDouble());
                player2.setY(dataIn.readDouble());
            }
        }catch(IOException ex){
            System.out.println("IOException from RFS run()");
        }
    }
    public void waitForStartMsg(){
        try{
            String startMsg = dataIn.readUTF();
            System.out.println("Message from server: "+startMsg);
            Thread readThread = new Thread(rfsRunnable);
            Thread writeThread = new Thread(wtsRunnable);
            readThread.start();
            writeThread.start();
        }catch(IOException ex){
            System.out.println("IOException from waitForStartMsg()");
        }
    }
}

/**
 * writes information to the server
 */

private class WriteToServer implements Runnable {
    private DataOutputStream dataOut;
    public WriteToServer(DataOutputStream out){
        dataOut = out;
        System.out.println("WTS Runnable created");
    }
    public void run(){
        try{
            while (true){
                dataOut.writeDouble(player1.getX()); //get ung x sa loob paren
                dataOut.writeDouble(player1.getY()); //get yung y
                dataOut.flush();
                try{
                    Thread.sleep(10);
                } catch(InterruptedException er){
                    System.out.println("InterruptedException from WTS run()");
                }
            }

        }catch(IOException ex){
            System.out.println("IOException from WTS run");
        }
    }
}

/**
 * starts the game thread
 */

public void startGameThread(){
    running = true;
    gameThread = new Thread(this);
    gameThread.start();
}

/**
 * stops the game thread
 */

public void stopGameThread(){
    running = false;
    try{
        gameThread.join();
    }catch(InterruptedException e){

    }
    
}

/**
 * checks if there is collision between an entity and a player
 * @param e the entity
 * @param player player
 * @return boolean if there is a collision
 */

public boolean checkCollision(Entity e, Player player){
    if(player.x + player.width <= e.getX() || 
    player.x >= e.getX() + e.getWidth() || player.y + player.height <= e.getY() ||
    player.y >= e.getY() + e.getHeight()){
        return false;
    }else{
        return true;
    }
}

/**
 * special collision checker for platforms and a player
 * @param player player
 * @param ps arraylist of platfirms
 * @return arraylist of platforms where there is collision
 */

public ArrayList<Platforms> Colliding(Player player, ArrayList<Platforms> ps){
    ArrayList<Platforms> collidingPlatforms = new ArrayList<Platforms>();
    for(Platforms a: ps){
        if(checkCollision(a, player)){
            collidingPlatforms.add(a);
        }
    }
    return collidingPlatforms; 
}

/**
 * this is what happens when there is a collision between a player and a platform
 * @param pfs platforms that collide with the player
 * @param player the player
 */

public void platformCollisions(ArrayList<Platforms> pfs , Player player){
    player.vely += player.gravity;
    player.y += player.vely;
    ArrayList<Platforms> collidingPfs = Colliding(player, pfs);
    if(collidingPfs.size() > 0){
        Platforms collided = collidingPfs.get(0);
        if(player.vely>0){
            player.setBottom(collided.getTop());
        }else if(player.vely<0){
            player.setTop(collided.getBottom());
        }
        player.vely = 0;
    }

    player.x += player.velx;
    collidingPfs = Colliding(player, pfs);
    if(collidingPfs.size() > 0){
        Platforms collided = collidingPfs.get(0);
        if(player.velx>0){
            player.setRight(collided.getLeft());
        }else if(player.velx<0){
            player.setLeft(collided.getRight());
        }
    }
    player.velx = 0;
}

/**
 * checks if a player is on top of a platform
 * @param player player
 * @param pfs the arraylist of platforms
 * @return true or false
 */

public boolean isOnPlatform(Player player, ArrayList<Platforms> pfs){
    player.y += 5;
    ArrayList<Platforms> collidingPfs = Colliding(player, pfs);
    player.y -= 5;
    if(collidingPfs.size() > 0){
        return true;
    }else{
        return false;
    }
}

/**
 * prevents the player from going off screen
 * @param player
 */

public void atBorder(Player player){
    if(player.x + player.width >= 800){
        player.x = 800-player.width;
    }if(player.x <= 0)
        player.x = 0;
}

/**
 * manages collision with Breezy and implements the effects of the power up
 * @param br array list of Breezy
 * @param player player
 */

public void breezyCollisions(ArrayList<Breezy> br , Player player){
    for(int i=0; i<br.size(); i++){
        if(checkCollision(br.get(i), player)){
            br.remove(i);
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    player.speed += 10;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    player.speed -= 10;

                }
            }).start();
            
        }else{
            continue;
        }
    }
}

/**
 * manages collision with Chocy 
 * @param cc
 * @param player
 */

public void chocyCollisions(ArrayList<Chocy> cc , Player player){
    for(int i=0; i<cc.size(); i++){
        if(checkCollision(cc.get(i), player)){
            cc.remove(i);
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    player.speed -= 4;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    player.speed += 4;

                }
            }).start();
            
        }else{
            continue;
        }
    }
}

/**
 * manages the players' collision with the flag
 * @param flag
 * @param player
 */

public void flagCollision(Flag flag, Player player){
    if(checkCollision(flag, player)){
        gc.gameOver = true;
    }
}

/**
 * animates the movements
 */

@Override
public void run(){

    double drawInterval = 1000000000/FPS;
    double nextDraw = System.nanoTime() + drawInterval;

    while(running){
        
        update();

        gc.repaint();

        try{
            double remainTime = nextDraw - System.nanoTime();
            remainTime = remainTime/1000000;

            if(remainTime < 0){
                remainTime = 0;
            }

            Thread.sleep((long) remainTime);
            nextDraw += drawInterval;
        }catch(InterruptedException e){

        }
        
    }
}

/**
 * updating the game
 */

public void update(){
    actions();
    atBorder(player1);
    platformCollisions(platforms, player1);
    platformCollisions(platforms, player2);
    breezyCollisions(breezies, player1);
    chocyCollisions(chocies, player1);
    breezyCollisions(breezies, player2);
    chocyCollisions(chocies, player2);
    flagCollision(flag, player1);
    flagCollision(flag, player2); 
}

 /**
 * moves the player based on keyboard input
 */

public void actions(){
    if(playerKey.playerUp == true && isOnPlatform(player1, platforms) == true){
        player1.vely = -player1.jumpVel;
    }else if(playerKey.playerDown == true){
        player1.vely = player1.speed;
    }else if(playerKey.playerRight == true){
        player1.velx = player1.speed;
    }else if(playerKey.playerLeft == true){
        player1.velx = -player1.speed;
    }else if(playerKey.startingPage == true){
        gc.start = false;
    }
}

}
