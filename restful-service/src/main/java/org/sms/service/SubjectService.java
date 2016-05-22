package org.sms.service;

import org.sms.database.entity.Subject;
import org.sms.database.manager.SubjectManager;
import org.sms.database.managerImpl.SubjectManagerImpl;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.Collection;

/**
 * @author mhajas
 */

@Path("/subject")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@Stateless
public class SubjectService {

    SubjectManager subjectManager = new SubjectManagerImpl();

    @GET
    @Path("/getAll")
    @Produces("application/json")
    public Collection<Subject> getSubject() {
        return subjectManager.getAllSubjects();
    }

    @GET
    @Path("/get/{id}")
    @Produces("application/json")
    public Subject getSubject(@PathParam("id") String id){
        Long parsedID = Long.parseLong(id);
        return subjectManager.getSubjectById(parsedID);
    }

    @PUT
    @Path("/add")
    @Produces("application/json")
    public Subject addSubject(@QueryParam("code") String code, @QueryParam("name") String name, @QueryParam("rating") String rating) {
        if (code == null) {
            throw new IllegalArgumentException("Code can't be null");
        }

        if (name == null) {
            throw new IllegalArgumentException("Name can't be null");
        }

        double parsedRating = 0;
        if (rating != null) {
            parsedRating = Double.parseDouble(rating);
        }
        Subject newSub = new Subject(code, name, parsedRating);
        subjectManager.createSubject(newSub);

        if (newSub.getId() == null) {
            throw new NullPointerException("Can't create subject.");
        }

        return subjectManager.getSubjectById(newSub.getId());
    }
}
