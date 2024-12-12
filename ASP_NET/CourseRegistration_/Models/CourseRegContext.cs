using Microsoft.EntityFrameworkCore;

namespace CourseRegistration_.Models
{

    public class CourseRegContext : DbContext
    {
        public CourseRegContext(DbContextOptions<CourseRegContext> options) 
            : base(options)
        {

        }

        public DbSet<Course> Course { get; set; }
        public DbSet<Instructor> Instructor { get; set; }
        public DbSet<Student> Student { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Course>().ToTable("Course");
            modelBuilder.Entity<Instructor>().ToTable("Instructor");
            modelBuilder.Entity<Student>().ToTable("Student");
        }

    }
}
