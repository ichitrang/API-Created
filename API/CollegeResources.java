import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/colleges/{course_name}")
public class CollegeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCollegesByCourse(@PathParam("course_name") String courseName) {
        College[] colleges = College.query.join(Course).filter(Course.name == courseName).all();
        CollegeDetails[] collegeDetails = new CollegeDetails[colleges.length];
        
        for (int i = 0; i < colleges.length; i++) {
            College college = colleges[i];
            CollegeDetails collegeInfo = new CollegeDetails();
            collegeInfo.name = college.name;
            collegeInfo.location = college.location;
            collegeInfo.courseName = courseName;
            collegeInfo.courseFee = null;
            collegeInfo.duration = null;
            collegeInfo.accommodation = null;
            collegeInfo.accommodationFee = null;
            
            for (Course course : college.courses) {
                if (course.name == courseName) {
                    collegeInfo.courseFee = course.courseFee;
                    collegeInfo.duration = course.duration;
                    collegeInfo.accommodation = course.accommodation;
                    collegeInfo.accommodationFee = course.accommodationFee;
                }
            }
            
            collegeDetails[i] = collegeInfo;
        }
        
        return Response.ok(collegeDetails).build();
    }
}