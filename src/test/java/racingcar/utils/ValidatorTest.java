package racingcar.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {


    @Test
    void checkCarNameSize() {
        List<String> carNamesLessThan1 = List.of();
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkCarNameSize(carNamesLessThan1);
        });

        List<String> carNamesEqual1 = List.of(" Toyota");
        Validator.checkCarNameSize(carNamesEqual1);

        List<String> carNameIsEmpty = List.of("Audi","    ");
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkCarNameSize(carNameIsEmpty);
        });

        List<String> carNamesGreaterThan8 = List.of("Audi", "BMW", "Mercedes", "Toyota", "Ford", "Hyundai", "Kia", "Nissan", "Chevrolet");
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkCarNameSize(carNamesGreaterThan8);
        });
    }

    @Test
    void checkCarNameDuplication() {
        List<String> carNamesNoDuplication = List.of("Ferrari", "Lamborghini", "Ford");
        Validator.checkCarNameDuplication(carNamesNoDuplication);

        List<String> carNamesWithDuplication = List.of("Ferrari", "Ford", "Lamborghini", "Ferrari");
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkCarNameDuplication(carNamesWithDuplication);
        });

        List<String> emptyCarNames = List.of();
        Validator.checkCarNameDuplication(emptyCarNames); // Should not throw an exception
    }

    @Test
    void checkCarNameIsEnglish() {
        List<String> carNamesEnglish = List.of("BMW", "Honda", "Ford");
        Validator.checkCarNameIsEnglish(carNamesEnglish);

        List<String> carNamesNonEnglish = List.of("Ferrari", "Ford", "페라리");
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkCarNameIsEnglish(carNamesNonEnglish);
        });

        List<String> carNamesNonEnglish2 = List.of("@", "!", "페라리");
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkCarNameIsEnglish(carNamesNonEnglish2);
        });

        List<String> emptyCarNames = List.of();
        Validator.checkCarNameIsEnglish(emptyCarNames);
    }
}