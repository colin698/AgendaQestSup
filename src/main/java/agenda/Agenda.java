package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {

    public ArrayList<Event> lesEvents = new ArrayList<>();
    public ArrayList<Event> lesEventsDAujourdhui = new ArrayList<>();
    public ArrayList<Event> lesTitresDEvents = new ArrayList<>();

    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        lesEvents.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        for (Event e1 : lesEvents) {
            if (e1.isInDay(day)) {
                lesEventsDAujourdhui.add(e1);
            }
        }
        return lesEventsDAujourdhui;
    }

    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     *
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        this.lesEvents.forEach((e) -> {
            if (e.getTitle().equals(title)) {
                this.lesTitresDEvents.add(e);
            }
        });
        return this.lesTitresDEvents;
    }
}
