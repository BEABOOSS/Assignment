using CourseRegistration_.Models;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;

namespace CourseRegistration_.Pages.InstructorList
{
    public class IndexModel : PageModel
    {
        private readonly CourseRegContext _db;
        public IndexModel(CourseRegContext db)
        {
            _db = db;
        }

        public IEnumerable<Instructor> Instructors { get; set; }

        public async Task OnGet()
        {
            Instructors = await _db.Instructor.ToListAsync();
        }
    }
}
