package Scenes;

import com.awesometuts.mylibgdxtester.GameMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;

import clouds.Cloud;
import helpers.GameInfo;
import player.Player;

public class MainMenu implements Screen, ContactListener {

    /**
     * Private method permet d'utiliser les attibuts de la classe GameMain
     * Detecting collision - 21/09/2019
     */
    private GameMain game;

    private Texture bg;

//    private Sprite player;

    private Player player;

    private World world;

    private OrthographicCamera box2DCamera;

    private Box2DDebugRenderer debugRenderer;

    public MainMenu(GameMain game) {
        this.game = game;

        box2DCamera = new OrthographicCamera();
        box2DCamera.setToOrtho(false, GameInfo.WIDTH / GameInfo.PPM, GameInfo.HEIGHT / GameInfo.PPM);

        box2DCamera.position.set(GameInfo.WIDTH / 2f, GameInfo.HEIGHT /2f, 0);

        debugRenderer = new Box2DDebugRenderer();


        world = new World(new Vector2(0, -9.8f), true);

        world.setContactListener(this);

        bg = new Texture("Game BG.png");

//        player = new Sprite(new Texture("Player 1.png"));
//        player.setPosition((GameInfo.WIDTH / 2) - player.getWidth() / 2, (GameInfo.HEIGHT / 2 ) -
//                player.getHeight() / 2);

        player = new Player(world, "Player 1.png", GameInfo.WIDTH / 2, GameInfo.HEIGHT / 2 + 250);

        Cloud c = new Cloud(world);


    }

    void update(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
//            player.getBody().applyLinearImpulse(new Vector2(-0.1f, 0),
//                    player.getBody().getWorldCenter(), true);

            player.getBody().applyForce(new Vector2(-5f, 0),
                    player.getBody().getWorldCenter(), true);
        } else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
//            player.getBody().applyLinearImpulse(new Vector2(-0.1f, 0),
//                    player.getBody().getWorldCenter(), true);

            player.getBody().applyLinearImpulse(new Vector2(0.1f, 0),
                    player.getBody().getWorldCenter(), true);
        }
    }

    /**
     * Called when this screen becomes the current screen for a {@link Game}.
     */
    @Override
    public void show() {

    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {

        update(delta);

        player.updatePlayer();

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        game.getBatch().draw(bg, 0, 0);
        game.getBatch().draw(player, player.getX(),player.getY() - player.getHeight() / 2f);
        game.getBatch().end();

        debugRenderer.render(world, box2DCamera.combined);

        world.step(Gdx.graphics.getDeltaTime(), 6, 2);

    }

    /**
     * @param width
     * @param height
     * @see ApplicationListener#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {

    }

    /**
     * @see ApplicationListener#pause()
     */
    @Override
    public void pause() {

    }

    /**
     * @see ApplicationListener#resume()
     */
    @Override
    public void resume() {

    }

    /**
     * Called when this screen is no longer the current screen for a {@link Game}.
     */
    @Override
    public void hide() {

    }

    /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose() {
        bg.dispose();
        player.getTexture().dispose();
    }

    /**
     * Called when two fixtures begin to touch.
     *
     * @param contact
     */
    @Override
    public void beginContact(Contact contact) {
        // System.out.println("Contact");

        Fixture firstBody, secondBody;

        if(contact.getFixtureA().getUserData() == "Player") {
            // setting the fixture A e.g. the player to the first body
            firstBody = contact.getFixtureA();
            secondBody = contact.getFixtureB();
        } else {
            firstBody = contact.getFixtureB();
            secondBody = contact.getFixtureA();
        }

        System.out.println("The name of the first body is " + firstBody.getUserData());
    }

    /**
     * Called when two fixtures cease to touch.
     *
     * @param contact
     */
    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
} // Main Menu
