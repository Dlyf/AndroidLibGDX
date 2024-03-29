package player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import helpers.GameInfo;

/**
 * 03/08/2019 - Extending the Sprite class
 * 15/09/2019 - This Physics System
 *            - Creating the world and making the player move
 */
public class Player extends Sprite {
    private World world;
    private Body body;

    // position of the player
    public Player(World world, String name, float x, float y) {

        super(new Texture(name));
        this.world = world;
        setPosition(x - getWidth() / 2f, y - getHeight() / 2f);
        createBody();
    }

    void createBody() {
        
        BodyDef bodyDef = new BodyDef();
        // a static body is not affected by gravity or other forces
        // a kinematic body is not affected by gravity but it is affected by other forces
        // dynamic body is affect by gravity and other forces
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        bodyDef.position.set(getX() / GameInfo.PPM, getY() / GameInfo.PPM);

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox((getWidth() / 2) / GameInfo.PPM, (getHeight() / 2) / GameInfo.PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1;


        Fixture fixture = body.createFixture(fixtureDef);

        fixture.setUserData("Player");

        shape.dispose();
    }

    public void updatePlayer() {
        this.setPosition(body.getPosition().x * GameInfo.PPM, body.getPosition().y * GameInfo.PPM);
    }

    public Body getBody() {
        return this.body;
    }

} // Player
