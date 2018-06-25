package com.softserve.lookingRegex;

import java.util.ArrayList;
import java.util.List;

public class Source {
	private static List<Movie> source = new ArrayList<Movie>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add(new Movie(
					"Tittle: The Shawshank Redemption; Actors: Tim Robbins, Morgan Freeman, Bob Gunton; Genre: Drama, Criminal; Directors:Frank Darabont; Studious Warner Brosers; Description:Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.;"));
			add(new Movie(
					"Tittle: The Godfather; Actors: Marlon Brando, Al Pacino, James Caan; Genre: Drama, Criminal; Directors:Francis Ford Coppola; Studious Amazon; Description:The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.;"));
			add(new Movie(
					"Tittle: The Dark Knight; Actors: Christian Bale, Heath Ledger, Aaron Eckhart; Genre: Action, Crime, Drama; Directors:Christopher Nolan; Description:When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham. The Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.;"));
			add(new Movie(
					"Tittle: Fight Club; Actors:Brad Pitt, Edward Norton, Meat Loaf; Genre:Drama; Directors:David Fincher; Studious Paramaunt Pictures; Description:An insomniac office worker, looking for a way to change his life, crosses paths with a devil-may-care soapmaker, forming an underground fight club that evolves into something much, much more.;"));
			add(new Movie(
					"Tittle: Pulp Fiction; Actors: John Travolta, Uma Thurman, Samuel L. Jackson; Genre: Action, Crime, Drama; Directors:Quentin Tarantino; Description:The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.;"));
			add(new Movie(
					"Tittle: Forrest Gump; Actors: Tom Hanks, Robin Wright, Gary Sinise; Genre: Drama, Romance; Description:The presidencies of Kennedy and Johnson, Vietnam, Watergate, and other history unfold through the perspective of an Alabama man with an IQ of 75.;"));
			add(new Movie(
					"Tittle: A big brother6; Actors: Brad Pit, Jhony Dapp; Genre: Drama, Criminal; Description:This is text;"));
			add(new Movie(
					"Tittle: A big brother7; Actors: Brad Pit, Jhony Dapp1; Genre: Drama, Criminal; Description:This is text;"));
			add(new Movie(
					"Tittle: A big brother8; Actors: Brad Pit1, Jhony Dapp; Genre: Drama, Criminal1; Description:This is text;"));
			add(new Movie(
					"Tittle: Test for 13 years; Actors:; Genre: Fantasy, Comedy, Serial; Description:This is text;"));
		}

	};

	public static List<Movie> getSource() {
		return source;
	}

}
