using CourseRegistration_.Models;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace CourseRegistration_.Pages.CourseList
{
    public class CourseInformationModel : PageModel
    {
        private readonly CourseRegContext _db;

        public CourseInformationModel(CourseRegContext db)
        {
            _db = db;
        }

        public Course Course { get; set; }
        public Instructor Instructor { get; set; }

        public async Task OnGet(int id)
        {
            Course = await _db.Course.FindAsync(id);
            Instructor = await _db.Instructor.FindAsync(Course.CourseId);
        }
    }
}
