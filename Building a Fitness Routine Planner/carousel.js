const carousels = document.querySelectorAll('.carousel-inner');

carousels.forEach(carouselInner => {
  const carouselItems = carouselInner.querySelectorAll('.carousel-item');
  let currentIndex = 0;

  function updateCarousel() {
    const offset = -currentIndex * 33.33;
    carouselInner.style.transform = `translateX(${offset}%)`;
  }

  function moveToNext() {
    currentIndex = (currentIndex + 1) % carouselItems.length;
    updateCarousel();
  }

  function startAutoSlide() {
    setInterval(() => {
      moveToNext();
    }, 3000);
  }

  updateCarousel();
  startAutoSlide();
});
