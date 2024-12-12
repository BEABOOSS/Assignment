using CourseRegistration_.Models;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;

namespace CourseRegistration_.Pages.CourseList
{
    public class IndexModel : PageModel
    {
        private readonly CourseRegContext _db;
        public IndexModel(CourseRegContext db)
        {
            _db = db;
        }

        public IEnumerable<Course> Courses { get; set; }

        public async Task OnGet()
        {
            Courses = await _db.Course.ToListAsync();
        }
    }
}
