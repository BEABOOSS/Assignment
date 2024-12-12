using CourseRegistration_.Models;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;

namespace CourseRegistration.Pages.StudentList
{
    public class IndexModel : PageModel
    {
        private readonly CourseRegContext _db;
        public IndexModel(CourseRegContext db)
        {
            _db = db;
        }

        public IEnumerable<Student> Students { get; set; }

        public async Task OnGet()
        {
            Students = await _db.Student.ToListAsync();
        }
    }
}
