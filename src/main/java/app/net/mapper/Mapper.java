package app.net.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Mapper<Entity, Dto> {
    public List<Dto> mapListEntity(List<Entity> entities) {
        if (entities == null) {
            return new ArrayList<>();
        }
        return entities.stream().map(this::mapEntity).collect(Collectors.toList());
    }

    public Set<Dto> mapSetEntity(Set<Entity> entities) {
        if (entities == null) {
            return new HashSet<>();
        }
        return entities.stream().map(this::mapEntity).collect(Collectors.toSet());
    }

    public List<Entity> mapListDto(List<Dto> dtos) {
        if (dtos == null) {
            return new ArrayList<>();
        }
        return dtos.stream().map(this::mapDto).collect(Collectors.toList());
    }

    abstract Dto mapEntity(Entity entity);

    abstract Entity mapDto(Dto dto);
}
