package TasksApp;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Note {
    private String note;
    private final ArrayList<String> notes;
    public Note(){
        notes = new ArrayList<>();
        this.startApp();
    }

    void startApp(){
        System.out.println("Welcome to the Notes App!");
        if(!notes.isEmpty()){
            System.out.println("All Notes:");
            this.displayNotes();
            this.options();
        } else {
            System.out.println("No Notes. Add Something!");
            this.addNote();
        }
    }
    void exitApp(){

    }
    void options(){
        System.out.println("All notes: ");
        this.displayNotes();
        System.out.println("---------------------");
        System.out.println("What do you want to do?");
        System.out.println("1. Add New Note");
        System.out.println("2. Edit Note");
        System.out.println("3. Delete note");
        System.out.println("4. View all Notes");
        System.out.println("5. Exit");
        System.out.println("---------------------");
        System.out.print("Enter Choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1: {
                this.addNote();
            }
            case 2: {
                this.displayNotes();
                System.out.print("Enter Note ID: ");
                int note_id = sc.nextInt();
                this.editNote();
            }
            case 3: {
                this.displayNotes();
                this.deleteNote();
            }
            case 4: {
                this.displayNotes();
                this.options();
            }
            case 5: {
                System.out.println("Thank You!");
                break;
            }
            default: {
                System.out.println("Wrong Choice");
                this.options();
            }
        }
    }
    public void addNote(){
        System.out.print("Type New Note: ");
        Scanner sc = new Scanner(System.in);
        String note = sc.nextLine();
        notes.add(note);
        System.out.println("Added Successfully");
        this.options();
    }

    public void displayNotes() {
        for(int i=0;i<notes.size();i++){
            System.out.println(i+". "+notes.get(i));
        }
    }

    public void editNote() {
        Scanner sc = new Scanner(System.in);
        int old_note = sc.nextInt();
        System.out.println("Old Note: "+ notes.get(old_note));
        System.out.print("Type Updated Note: ");
        String updatedNote = sc.nextLine();
        notes.set(old_note, updatedNote);
        System.out.println("Updated Successfully");
        this.options();
    }

    public void deleteNote() {
        System.out.print("Enter Note ID: ");
        Scanner sc = new Scanner(System.in);
        int note_id = sc.nextInt();
        System.out.println("Confirm delete? "+notes.get(note_id));
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Confirm Choice: ");
        int choice = sc.nextInt();
        switch (choice){
            case 1: {
                notes.remove(note_id);
                System.out.println("Deleted Successfully");
                this.options();
            }
            default: {
                System.out.println("Invalid Choice");
                this.deleteNote();
            }
        }
    }
}
