using System.ComponentModel.DataAnnotations;

namespace CourseRegistration_.Models
{
    public class Instructor
    {
        [Key]
        public int InstructorId { get; set; }

        [Required]
        public string FirstName { get; set; }
        [Required]
        public string LastName { get; set; }
        [Required]
        public string Email { get; set; }

        //FK for courseId that they teach Max of one course 
        public int CourseId { get; set; }
        public Course Course { get; set; }

    }
}
