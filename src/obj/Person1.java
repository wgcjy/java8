package obj;

import java.util.Optional;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-08-24 16:09
 **/
public class Person1 {
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }
}


class Car {

    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}

class Insurance {
    private String name;

    public String getName() {
        return name;
    }
}