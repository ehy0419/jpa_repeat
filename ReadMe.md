# 작성 순서 - 바텀업 방식
## Entity → Repository → Service → Controller → Dto

1. 구조잡기
   (controller, repository, service, entity, dto)
2. Entity & Repository 생성
movie 엔티티
   (@Getter, @Entity, @NoArgsConstructor, @Id, @GeneratedValue(starategy = GenerationType.IDENTITY))
review 엔티티
   (@ManyToOne과 @JoinColumn은 항상 같이 다닌다!)


* 궁금한 것
1) new EntityNotFoundException("Movie not found"));
2) FetchType.LAZY 와 FetchType.EAGER
3) nullable = false 와 nullable = true


* 작성 중 발생한 버그?
1) 오타 @RequestBody MovieRequest request 에서 @ResponseBody MovieRequest request 으로 수정
2) 오타 List<Review> findAllMovieId(Movie movie) 에서 List<Review> findAllByMovie(Movie movie) 으로 수정
3) 타입 불일치 엔티티에서 int로 생성, 영화 응답에서 Long 으로 호출
4) @Service 로 스프링 빈으로 등록하지 않아 주입할 수 없는 오류 발생. (ReviewService에 @)