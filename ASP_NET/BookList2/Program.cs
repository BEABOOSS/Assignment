using BookList2.Model;
using Microsoft.EntityFrameworkCore;

namespace BookList2
{
    public class Program
    {
        public static void Main(string[] args)
        {

            var builder = WebApplication.CreateBuilder(args);
            var connectionString =
                builder.Configuration.GetConnectionString("DefaultConnection")
                ?? throw new InvalidOperationException("Connection string" + "'DefaultConnection' not found.");


            builder.Logging.AddFilter("Microsoft.AspNetCore.HttpsLogging", LogLevel.Information);
            builder.Services.AddRazorPages().AddRazorRuntimeCompilation();
            builder.Services.AddControllersWithViews();
            builder.Services.AddDbContext<ApplicationDbContext>(option => option.UseSqlServer(connectionString));

            var app = builder.Build();

            // Configure the HTTP request pipeline.
            if (!app.Environment.IsDevelopment())
            {
                app.UseHttpLogging();
                app.UseExceptionHandler("/Error");
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }


            app.UseHttpsRedirection();


            app.UseRouting();

            app.UseAuthorization();
            app.MapStaticAssets();


            app.MapControllers();


            app.MapRazorPages()
               .WithStaticAssets();

            app.Run();
        }
    }
}
