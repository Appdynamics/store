/*
 * Copyright 2010-2012 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazon.aws.samplecode.travellog.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Maps to a journal.  In the current implementation there is ever
 * only one journal, but data structure could support multiple journals
 * if needed later.
 */
@Entity
public class Journal {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;

    @Column(unique=true, nullable=false)
    private String title;
    private String description;
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER,mappedBy="journal")
    private List<Entry> entries = new ArrayList<Entry>();
    private Date startDate = Calendar.getInstance().getTime();
    private Date endDate = Calendar.getInstance().getTime();


    SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");

    public Journal() {
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDateRangeString () {
        StringBuffer dateRangeSb = new StringBuffer();
        dateRangeSb.append(formatter.format(startDate));
        if (endDate!=null) {
            dateRangeSb.append(" - ").append(formatter.format(endDate));
        }
        return dateRangeSb.toString();
    }

    public void setDateRangeString (String dateRangeString) {
        //Do nothing this is never stored, always generated
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public void addEntry (Entry entry) {
        getEntries().add(entry);
    }

    public Entry getEntry(int fileId) {
        for (Entry e:getEntries()) {
            if (fileId == e.getFileId()) {
                return e;
            }
        }
        return null;
    }

    public Entry getEntryById(String id) {
        if (id == null) throw new IllegalArgumentException("Id cannot be null");
        for(Entry e:getEntries()) {
            if (id.equals(e.getId())) {
                return e;
            }
        }
        return null;
    }

    public Entry getEntryByTitle(String title) {
        if (title == null) throw new IllegalArgumentException("title cannot be null");
        for(Entry e:getEntries()) {
            if (title.equals(e.getTitle())) {
                return e;
            }
        }
        return null;
    }
}
