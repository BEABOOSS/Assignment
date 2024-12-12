using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CourseRegistration_.Models
{
    public class Course
    {
        [DatabaseGenerated(DatabaseGeneratedOption.None)]
        public int CourseId { get; set; }

        [Required]
        public string CourseNumber { get; set; }
        [Required]
        public string CourseName { get; set; }

        [Required]
        // might need to be text or something when storing in the db
        public string Description { get; set; }

        public Instructor Instructor { get; set; }
    }
}
