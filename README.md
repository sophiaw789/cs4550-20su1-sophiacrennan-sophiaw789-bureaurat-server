The API URL is https://neustudyserver.herokuapp.com

Models:

	User: Integer id, String username, String password, Boolean admin, List<StudyGroup> courses
 
		I was unsure if it would be better to have separate users, like Admin and Student 
		or to simply have an admin boolean field.
	
	StudyGroup: Integer id, Integer courseId, String name, List<User> studentsInGroup, List<Post> posts
	
	AdminStudyGroup and StudentStudyGroup both extend StudyGroup
	
	Post: Integer id, Integer studyGroupId, User poster, String title, String text, String date, List<Comment> comments
	
	Comment: Integer id, Integer postId, User commenter, String text, String date

Controllers:

	User: I also included sessions.
		These Post Mapping methods return the currentUser:
			register: "/api/register"
			login: "/api/login"
		This is the Get Mapping method to retrieve the currentUser:
			profile: "/api/profile"
		Void Method:
			logout: "/api/logout"
	
	Methods:
		update, create, findAll, findById, delete, findForCourse
	
	AdminStudyGroup:
		create, findForCourse endpoint: "/api/courses/{courseId}/studygroups/admin"
		
		update, findAll, findById, delete endpoint: "/api/studygroups/admin/"
	
	StudentStudyGroup:
		create, findForCourseendpoint: "/api/courses/{courseId}/studygroups/student"
		
		update, findAll, findById, delete endpoint: "/api/studygroups/admin/"
	
	Post:
		endpoint: "/api/studygroup/{studyId}/posts/"
		
	Comment:
		endpoint: "/api/posts/{postId}/comments/"

Services:
	
	User: 
		findUserByCredentials, findUsersForStudyGroup, findUserById, findAllUsers, 
		create, update, delete

I was not able to get the MySQL to work with the server so I excluded it.
