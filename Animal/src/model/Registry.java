package model;

import model.animals.Cats;
import model.animals.Dogs;
import model.animals.Hamster;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Registry implements Serializable {
    private List<Cats> catsList;
    private List<Dogs> dogsList;
    private List<Hamster> hamsterList;

    public Registry() {
        this.catsList = new ArrayList<>();
        this.dogsList = new ArrayList<>();
        this.hamsterList = new ArrayList<>();
    }

    public List<Cats> getCatsList() {
        return catsList;
    }

    public void setCatsList(List<Cats> catsList) {
        this.catsList = catsList;
    }

    public List<Dogs> getDogsList() {
        return dogsList;
    }

    public void setDogsList(List<Dogs> dogsList) {
        this.dogsList = dogsList;
    }

    public List<Hamster> getHamsterList() {
        return hamsterList;
    }

    public void setHamsterList(List<Hamster> hamsterList) {
        this.hamsterList = hamsterList;
    }
    public String catInfo() {
        StringBuilder sb = new StringBuilder();
        if (catsList.size() > 0) {
            for (int i = 0; i < catsList.size(); i++) {
                sb.append(i + 1);
                sb.append(". ");
                sb.append(catsList.get(i).toString());
                sb.append("\n");
            }
        } else sb.append("Котиков сейчас нет");
        return sb.toString();
    }
    public String dogInfo() {
        StringBuilder sb = new StringBuilder();
        if (dogsList.size() > 0) {
            for (int i = 0; i < dogsList.size(); i++) {
                sb.append(i + 1);
                sb.append(". ");
                sb.append(dogsList.get(i).toString());
                sb.append("\n");
            }
        } else sb.append("Собачек сейчас нет");
        return sb.toString();
    }
    public String hamsterInfo() {
        StringBuilder sb = new StringBuilder();
        if (hamsterList.size() > 0) {
            for (int i = 0; i < hamsterList.size(); i++) {
                sb.append(i + 1);
                sb.append(". ");
                sb.append(hamsterList.get(i).toString());
                sb.append("\n");
            }
        } else sb.append("Хомячков сейчас нет");
        return sb.toString();
    }
}

