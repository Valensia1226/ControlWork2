package view;


import model.AnimalType;
import presenter.Presenter;
import view.commands.FirtsMenu;
import view.commands.MainMenu;
import view.examination.Exam;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;
    private FirtsMenu firtsMenu;
    private String pathRemember;
    private Exam exam;
    private final String YEAR = "Укажите год";
    private final String MONTH = "Укажите месяц";
    private final String DAY = "Укажите день";

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
        firtsMenu = new FirtsMenu(this);
        exam = new Exam();
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (work) {
            System.out.println();
            System.out.println(mainMenu.getMenu());
            int choice = takeChoice(mainMenu.getSize());
            if (choice != -1) mainMenu.execute(choice);
            else System.out.printf("Некорректно введена команда. Введите число от 1 до %d\n", mainMenu.getSize());
        }
    }

    private void hello() {
        System.out.println(firtsMenu.getMenu());
        int choice = takeChoice(firtsMenu.getSize());
        if (choice != -1) firtsMenu.execute(choice);
        else {
            System.out.printf("Некорректно введена команда. Введите число от 1 до %d\n", firtsMenu.getSize());
            hello();
        }
    }
    public void startNewProject() {
    }
    public void downlandProject() {
        print("Укажите имя файла:");
        String name = scanner.nextLine();
        if (!name.contains(".out")) name = name + ".out";
        this.pathRemember = name;
        if (!downland(name)) {
            System.out.println("Файл не найден");
            downlandProject();
        }
    }
    public boolean downland(String path) {
        return presenter.downland(path);
    }
    private int takeChoice(int size) {
        String line = scanner.nextLine();
        int choice = exam.itsNumber(line);
        if ((choice > size) || (choice <= 0)) return -1;
        return choice;
    }
    public void finishAfterWork() {
        print("Вы хотите сохранить работу над проектом?");
        String answer = scanner.nextLine();
        if (answer.equals("да") || answer.equals("yes")) {
            if (pathRemember != null) {
                if (!save(pathRemember)) print("К сожалению, не получилось сохранить файл!");
                else print("Успешно сохранили вашу работу!");
            } else {
                print("Введите имя файла на английском: ");
                String name = scanner.nextLine().toLowerCase();
                name = name + ".out";
                if (!save(name)) print("К сожалению, не получилось сохранить файл!");
                else print("Успешно сохранили вашу работу!");
            }
        }
        System.out.println("До свидания!");
        work = false;
    }
    public void finishBeforeWork() {
        System.out.println("До свидания!");
        work = false;
    }
    public boolean save(String name) {
        return presenter.save(name);
    }
    public void returnToFirstMenu() {
        hello();
    }


    public void addNewAnimal() {
        print("Введите имя");
        String name = scanner.nextLine();
        print("Укажите дату рождения:");
        int year = data(YEAR);
        while (exam.yearExamination(year)) {
            year = data(YEAR);
        }
        int month = data(MONTH);
        while (exam.monthExamination(month)) {
            month = data(MONTH);
        }
        int day = data(DAY);
        while (exam.dayExamination(day, month, year)) {
            day = data(DAY);
        }
        LocalDate birthDate = LocalDate.of(year, month, day);
        int number = type("Укажите номер типа животного:\n 1. Кот \n 2. Собака \n 3. Хомяк");
        AnimalType type = null;
        if (number == 1) type = AnimalType.Cat;
        else if (number == 2) type = AnimalType.Dog;
        else if (number == 3) type = AnimalType.Hamster;
        try {
            presenter.addNewAnimal(name, birthDate, type);
        } catch (Exception e) {
            throw new RuntimeException("Счетчик не закрылся");
        }
    }
    private int type (String descr){
        String str;
        System.out.println(descr);
        str = scanner.nextLine();
        if (str.length() != 1){
            print("Введено больше или меньше одной цифры!");
            type(descr);
        }
        int number = exam.itsNumber(str);
        if (number == -1) type(descr);
        return number;
    }
    private int data(String descr){
        String str;
        System.out.println(descr);
        str = scanner.nextLine();
        int data = exam.itsNumber(str);
        if (data == -1) {
            data(descr);
        }
        return data;
    }
    public void learnNewCommand() {
        AnimalType type = petChoice();
        print("Выберите животное (введите номер)");
        int num = scanner.nextInt();
        print(presenter.learnNewCommand(type, num));
    }

    public void petCommand() {
        AnimalType type = petChoice();
        print("Выберите животное (введите номер)");
        int num = scanner.nextInt();
        print(presenter.showAnimalComman(type, num));
    }
    private AnimalType petChoice(){
        int number = type("Какое животное?\n 1. Кот \n 2. Собака \n 3. Хомяк");
        AnimalType type = null;
        if (number == 1) {
            print(presenter.showCatsList());
            type = AnimalType.Cat;
        }
        else if (number == 2) {
            print(presenter.showDogsList());
            type = AnimalType.Dog;
        }
        else if (number == 3) {
            print(presenter.showHamstersList());
            type = AnimalType.Hamster;
        }
        return type;
    }
}
