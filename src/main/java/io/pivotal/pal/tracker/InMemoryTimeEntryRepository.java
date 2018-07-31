package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> timeEntryMap = new HashMap<Long, TimeEntry>();
    private int id = 1;


    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(id++);
        timeEntryMap.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        return timeEntryMap.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(timeEntryMap.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (timeEntryMap.get(id) != null) {
            timeEntry.setId(id);
            timeEntryMap.put(id, timeEntry);
            return timeEntry;
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        if (timeEntryMap.get(id) != null) {
            timeEntryMap.remove(id);
        }
    }
}
