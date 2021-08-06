package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {

    private static final String SPACESHIP_NAME = "Galactica";
    private static final int CAPACITY = 100;
    private static final int ZERO_CAPACITY = 0;
    private static final String ASTRONAUT_NAME = "Apollo";
    private static final double ASTRONAUT_OXYGEN = 3.14;
    private  Astronaut astronaut;
    private Spaceship spaceship;

    @Before
    public void InitialisingNewTestObjects(){
        this.spaceship = new Spaceship(SPACESHIP_NAME, CAPACITY);
        this.astronaut = new Astronaut(ASTRONAUT_NAME, ASTRONAUT_OXYGEN);
    }


    @Test
    public void constructorInitialiseNewInstance() {
        Assert.assertNotNull(spaceship);
    }

    @Test(expected = NullPointerException.class)
    public void setNameThrowsIfNameNull() {
        String name = null;
        this.spaceship = new Spaceship(name, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void setNameThrowsIfNameIsEmpty() {
        String name = " ";
        this.spaceship = new Spaceship(name, CAPACITY);
    }

    @Test
    public void setNameWorksProperly() {
        String expected = SPACESHIP_NAME;
        Assert.assertEquals(expected, spaceship.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacityThrowsIfBelowZero() {
        int capacity = -3;
        this.spaceship = new Spaceship(SPACESHIP_NAME, capacity);
    }

    @Test
    public void setCapacityWorksProperlyIfCapacityZero() {
        int expected = ZERO_CAPACITY;
        this.spaceship = new Spaceship(SPACESHIP_NAME, ZERO_CAPACITY);
        Assert.assertEquals(expected, spaceship.getCapacity());
    }

    @Test
    public void setCapacityWorksProperlyIfCapacityMoreThenZero() {
        int expected = CAPACITY;
        Assert.assertEquals(expected, spaceship.getCapacity());
    }

    @Test
    public void getCapacityWorksProperlyIfCapacityZero() {
        //TODO same as  setCapacityWorksProperlyIfCapacityZero()
        int expected = ZERO_CAPACITY;
        this.spaceship = new Spaceship(SPACESHIP_NAME, ZERO_CAPACITY);
        Assert.assertEquals(expected, spaceship.getCapacity());
    }

    @Test
    public void getCapacityWorksProperlyIfCapacityMoreThenZero() {
        //TODO same as  setCapacityWorksProperlyIfCapacityMoreThenZero()
        int expected = CAPACITY;
        Assert.assertEquals(expected, spaceship.getCapacity());
    }

    @Test
    public void getNameReturnsTheNameOfTheSpaceShip() {
        String expected = SPACESHIP_NAME;
        Assert.assertEquals(expected, spaceship.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addThrowsIfFullCapacity() {
       this.spaceship = new Spaceship(SPACESHIP_NAME, ZERO_CAPACITY);
        this.spaceship.add(astronaut);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addThrowsIfAstronautAlreadyExists() {
        this.spaceship.add(astronaut);
        this.spaceship.add(astronaut);
    }

    @Test
    public void addWorksProperly() {
        int expected = 1;
        this.spaceship.add(astronaut);
        Assert.assertEquals(expected, this.spaceship.getCount());
    }

    @Test
    public void getCountReturnsTheSizeOfAstronautCollection() {
        // TODO same as addWorksProperly()
        spaceship.add(astronaut);
        int expected = 1;
        Assert.assertEquals(expected, this.spaceship.getCount());
    }

    @Test
    public void removeReturnsTrueIfAstronautRemoved() {
        spaceship.add(astronaut);
        Assert.assertTrue(this.spaceship.remove(ASTRONAUT_NAME));
    }

    @Test
    public void removeReturnsFalseIfAstronautNotRemoved() {
        spaceship.add(astronaut);
        Assert.assertFalse(this.spaceship.remove("Athina"));
    }

}
