package server.example.server.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import server.example.server.Models.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {


        @Query("{username: { $regex: ?0 } })")
        public Users findUsersByUsername(String username);

}
