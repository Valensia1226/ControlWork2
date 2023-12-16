package presenter;

import model.AnimalType;
import model.service.Service;
import view.View;

import java.time.LocalDate;


public class Presenter {
    private View view;
    private Service service;
    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }
    public boolean save(String path) {
        return service.save(path);
    }
    public boolean downland(String path) {
        return service.dowland(path);
    }


    public void addNewAnimal(String name, LocalDate birthDate, AnimalType type) throws Exception {
        service.addNewAnimal(name, birthDate, type);
    }

    public String showCatsList() {
        String str = service.showCatsList();
        return str;
    }

    public String showDogsList() {
        return service.showDogsList();
    }

    public String showHamstersList() {
        return service.showHamstersList();
    }

    public String showAnimalComman(AnimalType type, int num) {
        return service.showAnimalCommands(type, num);
    }

    public String learnNewCommand(AnimalType type, int num) {
        return service.learnNewCommand(type, num);
    }
}
