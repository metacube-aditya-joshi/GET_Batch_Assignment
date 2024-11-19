document.querySelectorAll('.collapsible-header').forEach((header) => {
    header.addEventListener('click', () => {
      const body = header.nextElementSibling;
      const isVisible = body.style.display === 'block';
      body.style.display = isVisible ? 'none' : 'block';
    });
  });