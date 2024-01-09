package com.org.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PSong {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String songName;

	private int year;

	private String movieName;

	@ManyToMany(mappedBy = "songs")
	private List<Playlist> playlistSongs = new ArrayList<>();

}
