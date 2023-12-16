package model.service;


import model.AnimalType;
import model.Counter;
import model.Registry;
import model.animals.Cats;
import model.animals.Dogs;
import model.animals.Hamster;
import model.commands.CommandList;
import model.commands.Commands;
import model.save_in_file.SaveInFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private Registry registry;
    private SaveInFile save;
    private CommandList commandList;

    public Service() {
        this.registry = new Registry();
        this.save = new SaveInFile();
        this.commandList = new CommandList();
    }

    public boolean save(String path) {
        try{
            save.write(path, registry);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public boolean dowland(String path) {
        try{
            this.registry = (Registry) save.read(path);
            return true;
        } catch (IOException | ClassNotFoundException e) {
            return false;
        }
    }

    public void addNewAnimal(String name, LocalDate birth, AnimalType type) throws Exception {
        boolean flag;
        if (name != null && birth != null) flag = true;
        else flag = false;
        try (Counter counter = new Counter()){
            counter.add(flag);
        }
        if (type.equals(AnimalType.Cat)){
            Cats cat = new Cats(name, birth);
            List<Cats> catsList = registry.getCatsList();
            catsList.add(cat);
            registry.setCatsList(catsList);
        }
        if (type.equals(AnimalType.Dog)){
            Dogs dog = new Dogs(name, birth);
            List<Dogs> dogsList = registry.getDogsList();
            dogsList.add(dog);
            registry.setDogsList(dogsList);
        }
        if (type.equals(AnimalType.Hamster)){
            Hamster hamster = new Hamster(name, birth);
            List<Hamster> hamsterList = registry.getHamsterList();
            hamsterList.add(hamster);
            registry.setHamsterList(hamsterList);
        }
    }

    public String showCatsList() {
        String str = registry.catInfo();
        return str;
    }

    public String showDogsList() {
        return registry.dogInfo();
    }
    public String showHamstersList() {
        return registry.hamsterInfo();
    }

    public String showAnimalCommands(AnimalType type, int num){
       String commands = "";
        if (type.equals(AnimalType.Cat)){
            List<Cats> catsList = registry.getCatsList();
            Cats cat = catsList.get(num - 1);
            commands = cat.getList();
        }
        if (type.equals(AnimalType.Dog)){
            List<Dogs> dogsList = registry.getDogsList();
            Dogs dog = dogsList.get(num - 1);
            commands = dog.getList();
        }
        if (type.equals(AnimalType.Hamster)){
            List<Hamster> hamsterList = registry.getHamsterList();
            Hamster hamster = hamsterList.get(num - 1);
            commands = hamster.getList();
        }
        if (commands.isEmpty()) return "Это животное ничего не умеет";
        else return commands;
    }

    public String learnNewCommand(AnimalType type, int num) {
        List<Commands> commands = new ArrayList<>();
        if (type.equals(AnimalType.Cat)){
            List<Cats> catsList = registry.getCatsList();
            Cats cat = catsList.get(num - 1);
            commands = cat.getCommands();
        }
        if (type.equals(AnimalType.Dog)){
            List<Dogs> dogsList = registry.getDogsList();
            Dogs dog = dogsList.get(num - 1);
            commands = dog.getCommands();
        }
        if (type.equals(AnimalType.Hamster)){
            List<Hamster> hamsterList = registry.getHamsterList();
            Hamster hamster = hamsterList.get(num - 1);
            commands = hamster.getCommands();
        }
        String description = "";
        if (commands.isEmpty()) {
            commands.add(commandList.getCommandList().get(0));
            description = commandList.getCommandList().get(0).getDescription();
        }
        else if (commands.size() == commandList.getCommandList().size()) return "Это животное уже все умеет";
        else{
            int i = commands.size();
            commands.add(commandList.getCommandList().get(i));
        }
        return "Выучена команда " + description;
    }
}
