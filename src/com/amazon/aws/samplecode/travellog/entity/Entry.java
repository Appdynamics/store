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


import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

import org.directwebremoting.annotations.RemoteProperty;
import org.directwebremoting.annotations.RemoteProxy;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * The entry class maps to a single journal entry. 
 */
@Entity
@RemoteProxy
public class Entry {

	@RemoteProperty
	private String id;

	@RemoteProperty
	private String title;

	@RemoteProperty
	private String entryText;
	
	@RemoteProperty
	private String destination;
	
	private Date date;

	@RemoteProperty
	private String formattedDate;

	private String snsArn;

	private Journal journal;

	private List<Comment> comments = new ArrayList<Comment>();

	private List<Photo> photos = new ArrayList<Photo>();

	private int fileId;
	
	
	private static final SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
		this.formattedDate = formatter.format(date);
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	
	@Lob //Lob annotation tells SimpleJPA to store the entry text in S3
	public String getEntryText() {
		return entryText;
	}
	public void setEntryText(String entryText) {
		this.entryText = entryText;
	}
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	public Journal getJournal() {
		return journal;
	}

	public void setJournal(Journal journal) {
		this.journal = journal;
	}

	@Transient
	public String getFormattedDate() {
		return formattedDate;
	}

	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}

	public String getSnsArn() {
		return snsArn;
	}

	public void setSnsArn(String snsArn) {
		this.snsArn = snsArn;
	}

	@Transient
	public SimpleDateFormat getFormatter() {
		return formatter;
	}

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true,mappedBy = "entry")
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@OneToMany(cascade = CascadeType.ALL,mappedBy="entry")
	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public void addPhoto(Photo photo) {
    	getPhotos().add(photo);
	}

	public void removePhoto(Photo photo) {
    	getPhotos().remove(photo);
	}

	public void addComment(Comment c) {
    	getComments().add(c);
    }

    public void removeComment(Comment c) {
    	getComments().remove(c);
	}
	
	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
}
