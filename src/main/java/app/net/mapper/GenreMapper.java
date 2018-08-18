package app.net.mapper;

import app.net.dto.GenreDto;
import app.net.entity.Genre;

public class GenreMapper extends Mapper<Genre, GenreDto> {
    public GenreDto mapEntity(Genre genre) {
        GenreDto dto = new GenreDto();
        dto.setId(genre.getId());
        dto.setName(genre.getGenreName());
        return dto;
    }

    @Override
    public Genre mapDto(GenreDto genreDto) {
        Genre genre = new Genre();
        genre.setId(genreDto.getId());
        genre.setGenreName(genreDto.getName());
        return genre;
    }
}
