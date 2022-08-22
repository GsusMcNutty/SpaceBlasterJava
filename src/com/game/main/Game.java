package com.game.main;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{
    public static final int WIDTH = 640, HEIGHT = WIDTH/ 12 * 9;
    private Thread thread;
    private boolean isRunning = false;
    private Handler handler;

    private EnemySpawner spawner;

    public Game(){
        init();

        //construct window
        new Window(WIDTH, HEIGHT, "Blaster", this);

        //KeyListener
        this.addKeyListener(new KeyInputs(handler,spawner));
        this.addMouseListener(new MouseInput(handler));

        //Make Objects
        handler.addObject(new Player(100,100, handler));
        handler.addObject(new EnemyBasic(300,300, handler));
        handler.addObject(new Asteroid(200,200,  handler));
    }
    private void init(){
        handler = new Handler();
        spawner = new EnemySpawner(handler);
        spawner.setSpawning(false);
    }
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        isRunning = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            isRunning = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // Game loop Logic (popular)
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/ amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime)/ ns;
            lastTime = now;
            while (delta >= 1){
                tick();
                delta--;
            }
            if(isRunning)
                render();
            frames ++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //FPS Print
                //System.out.println("FPS: " + frames);
            }
        }
        stop();
    }

    private void tick(){
        handler.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        //Draw Background
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0, WIDTH, HEIGHT);

        //Handler Drawing
        handler.render(g);

        g.dispose();
        bs.show();
    }

    public static void main(String[] args){
        new Game();
    }
}
